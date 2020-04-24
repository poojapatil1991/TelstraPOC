package com.example.myapplication.telstraPOC.utils
/*
MVP architecture
 */
interface IMVP {
    interface Model

    interface View

    interface Presenter<V : View?> {
        fun onAttachView(view: V)
        fun onDettachView()
    }
}