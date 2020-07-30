package com.sablab.domvetdoctor.di.addcar
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.sablab.domvetdoctor.di.viewmodels.AddCarViewModelFactory
//import com.sablab.domvetdoctor.ui.addcar.AddCarViewModel
//import dagger.Binds
//import dagger.Module
//import dagger.multibindings.IntoMap
//
//@Module
//abstract class AddCarViewModelModule {
//
//    @AddCarScope
//    @Binds
//    abstract fun bindViewModelFactory(factory: AddCarViewModelFactory): ViewModelProvider.Factory
//
//    @AddCarScope
//    @Binds
//    @IntoMap
//    @AddCarViewModelKey(AddCarViewModel::class)
//    abstract fun bindAddCarViewModel(viewModel: AddCarViewModel): ViewModel
//
//
//}