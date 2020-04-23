package com.example.myapplication.TelstraPOC.utils
/*
MVP architecture
 */
interface MVP {
    interface Model

    interface View

    interface Presenter<V : View?> {
        fun onAttachView(view: V)
        fun onDettachView()
    }
}