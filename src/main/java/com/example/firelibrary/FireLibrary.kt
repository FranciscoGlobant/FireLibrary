package com.example.firelibrary

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

object FireLibrary {

    fun showRegistrationToken(listener: com.example.firelibrary.OnCompleteListener){
         FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "getInstanceId failed", task.exception)
                    listener.onFailure()
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token
                Log.d(TAG, token)
                listener.onSuccess(token)
            })
    }
}