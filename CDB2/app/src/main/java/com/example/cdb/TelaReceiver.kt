package com.example.cdb2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TelaReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Desbloqueio realizado com sucesso!", Toast.LENGTH_SHORT).show()
    }
}