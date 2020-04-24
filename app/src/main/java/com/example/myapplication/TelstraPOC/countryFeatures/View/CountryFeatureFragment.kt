package com.example.myapplication.TelstraPOC.countryFeatures.View

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapplication.R
import com.example.myapplication.TelstraPOC.utils.CountryFeatureApplication
import com.example.myapplication.TelstraPOC.executer.ExecuterThread
import com.example.myapplication.TelstraPOC.countryFeatures.CountryFeatureMVP
import com.example.myapplication.TelstraPOC.countryFeatures.CountryFeatureUseCase
import com.example.myapplication.TelstraPOC.countryFeatures.Model.CountryFeature
import com.example.myapplication.TelstraPOC.countryFeatures.Model.CountryFeatureRequestModel
import com.example.myapplication.TelstraPOC.countryFeatures.Model.ResponseModel
import com.example.myapplication.TelstraPOC.countryFeatures.Presenter.CountryFeaturePresenter
import com.example.myapplication.TelstraPOC.executer.UIThread
import com.example.myapplication.TelstraPOC.module.ApiModule
import com.example.myapplication.TelstraPOC.module.ThreadModule

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountryFeatureFragment : Fragment(), CountryFeatureMVP.View, SwipeRefreshLayout.OnRefreshListener {

    lateinit var mDialog: Dialog
    lateinit var mContext: Activity
    lateinit var mRVImageList: RecyclerView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mCountryFeatureAdapter: CountryFeatureAdapter
    private lateinit var mCountryFeaturePresenter : CountryFeaturePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_feature, container, false)

        mRVImageList = view.findViewById(R.id.rv_image_list) as RecyclerView
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        mSwipeRefreshLayout.setOnRefreshListener(this)

        mDialog = Dialog(mContext)
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)

        val uiThread: UIThread = ThreadModule().providePostExecutionThread()
        val executorThread: ExecuterThread = ThreadModule().provideExecutorThread()

        val countryFeatureReqModel = CountryFeatureRequestModel()
        countryFeatureReqModel.setApi(ApiModule().provideAllApi())

        val countryFeatureUsecase = CountryFeatureUseCase(executorThread,uiThread)
        countryFeatureUsecase.request = countryFeatureReqModel

        mCountryFeaturePresenter = CountryFeaturePresenter(countryFeatureUsecase)
        mCountryFeaturePresenter.onAttachView(this)

        mCountryFeaturePresenter.loadCountryFeatureList()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showError(message: String?) {
        hideLoading()
        Toast.makeText(CountryFeatureApplication.context,message,Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("WrongConstant")
    override fun showCountryFeatureList(
        reaponseModel: ResponseModel?
    ) {
        (activity as CountryFeatureActivity).setToolbarTitle(reaponseModel!!.title)
        var mModifiedList : ArrayList<CountryFeature> = ArrayList()
        try{
            if (reaponseModel!!.rows.isNotEmpty()) {
                // mGeneralInfoList.clear()

                for (item in reaponseModel!!.rows){
                    var mTitle : String = "No Title"
                    var mDescription : String = "No Description"
                    var mUrl : String = "No Url"
                    var isAllNull : Boolean = false

                    if(item.title.isNullOrBlank() && item.description.isNullOrBlank() && item.imageHref.isNullOrBlank()){
                        isAllNull = true
                    }else{
                        if(item.title.isNullOrBlank()){
                            item.title = mTitle
                        }
                        if(item.description.isNullOrBlank()){
                            item.description = mDescription
                        }
                        if(item.imageHref.isNullOrBlank()){
                            item.imageHref = mUrl
                        }
                    }
                    if(!isAllNull){
                        mModifiedList.add(item)}
                }
                mRVImageList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
                mRVImageList.itemAnimator = DefaultItemAnimator()
                mCountryFeatureAdapter = CountryFeatureAdapter(mModifiedList)
                mRVImageList.adapter = mCountryFeatureAdapter
            }

        }catch (e : Exception){
            hideLoading()
            e.printStackTrace()
        }
    }
    fun showProgressDialog() {
        mDialog.setContentView(R.layout.progress_dialog_layout)
        mDialog.show()
    }

    override fun onRefresh() {
        mSwipeRefreshLayout.isRefreshing = false
        mCountryFeaturePresenter.loadCountryFeatureList()
    }

    override fun showLoading() {
        if(!mDialog.isShowing){
            showProgressDialog()
        }
    }

    override fun hideLoading() {
        if(mDialog.isShowing){
            mDialog.hide()
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mContext = activity;
    }
}
