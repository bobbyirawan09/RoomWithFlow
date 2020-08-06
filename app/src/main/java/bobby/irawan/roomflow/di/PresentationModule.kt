package bobby.irawan.roomflow.di

import bobby.irawan.roomflow.CatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by bobbyirawan09 on 06/08/20.
 */
val presentationModule  = module{
    viewModel {
        CatViewModel(get())
    }
}