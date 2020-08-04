package com.sablab.domvetdoctor.ui.biographyexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sablab.domvetdoctor.R
import com.sablab.domvetdoctor.ui.BaseActionbarActivity
import kotlinx.android.synthetic.main.activity_select_city.*

class BiographyExampleActivity : BaseActionbarActivity() {

    override fun inject() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_biography_example)
        setSupportActionBar(tool_bar)
        super.onCreate(savedInstanceState)


    }



}