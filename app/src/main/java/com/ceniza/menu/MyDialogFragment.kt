package com.ceniza.menu

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Dialog Title")
            .setMessage("This is a message.")
            .setPositiveButton("Go to Fragment") { dialog, _ ->

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AnotherFragment())
                    .addToBackStack(null)
                    .commit()
            }
            .setNegativeButton("Dismiss") { dialog, _ ->

                dialog.dismiss()
            }
        return builder.create()
    }
}
