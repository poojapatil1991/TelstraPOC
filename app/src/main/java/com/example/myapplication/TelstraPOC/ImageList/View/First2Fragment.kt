package com.example.myapplication.TelstraPOC.ImageList.View

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
import com.example.myapplication.TelstraPOC.Commen.AppContext
import com.example.myapplication.TelstraPOC.Executer.ExecuterThread
import com.example.myapplication.TelstraPOC.Executer.PostExecuterThread
import com.example.myapplication.TelstraPOC.ImageList.ImageListMVP
import com.example.myapplication.TelstraPOC.ImageList.ImageListUseCase
import com.example.myapplication.TelstraPOC.ImageList.Model.ImageDetails
import com.example.myapplication.TelstraPOC.ImageList.Model.ImageListRequestModel
import com.example.myapplication.TelstraPOC.ImageList.Model.ResponseModel
import com.example.myapplication.TelstraPOC.ImageList.Presenter.ImageListPresenter
import com.example.myapplication.TelstraPOC.Module.ApiModule
import com.example.myapplication.TelstraPOC.Module.ThreadModule

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class First2Fragment : Fragment(), ImageListMVP.View, SwipeRefreshLayout.OnRefreshListener {

    lateinit var mDialog: Dialog
    lateinit var mContext: Activity
    lateinit var mRVImageList: RecyclerView
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mImageListAdapter: ImageListAdapter
    private lateinit var mImageListPresenter : ImageListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first2, container, false)

        mRVImageList = view.findViewById(R.id.rv_image_list) as RecyclerView
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        mSwipeRefreshLayout.setOnRefreshListener(this)

        mDialog = Dialog(mContext)
        mDialog.setCancelable(false)
        mDialog.setCanceledOnTouchOutside(false)

        val uiThread: PostExecuterThread = ThreadModule().providePostExecutionThread()
        val executorThread: ExecuterThread = ThreadModule().provideExecutorThread()

        val imageListReqModel = ImageListRequestModel()
        imageListReqModel.setApi(ApiModule().provideAllApi())

        val imageListUsecase = ImageListUseCase(executorThread,uiThread,imageListReqModel)
        imageListUsecase.request = imageListReqModel

        mImageListPresenter = ImageListPresenter(imageListUsecase)
        mImageListPresenter.onAttachView(this)

        mImageListPresenter.loadMovieList()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showError(message: String?) {
        Toast.makeText(AppContext.context,message,Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("WrongConstant")
    override fun showImageList(
        reaponseModel: ResponseModel?
    ) {
        (activity as ImageListActivity).setToolbarTitle(reaponseModel!!.title)
        var mModifiedList : ArrayList<ImageDetails> = ArrayList()
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
                mImageListAdapter = ImageListAdapter(mModifiedList)
                mRVImageList.adapter = mImageListAdapter
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    fun showProgressDialog() {
        mDialog.setContentView(R.layout.progress_dialog_layout)
        mDialog.show()
    }

    override fun onRefresh() {
        mSwipeRefreshLayout.isRefreshing = false
        mImageListPresenter.loadMovieList()
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
