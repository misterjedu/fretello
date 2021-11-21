package com.jedun.fretollochallenge.presentation.util

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jedun.fretollochallenge.R

fun Fragment.showDialog(value: Int) {

    MaterialAlertDialogBuilder(this.requireContext())
        .setTitle(resources.getString(R.string.output))
        .setMessage("The calculated maximum increase is $value BPM")
        .setPositiveButton("Okay") { dialog, which ->
            dialog.dismiss()
        }
        .show()

}