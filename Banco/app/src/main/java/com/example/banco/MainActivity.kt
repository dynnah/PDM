package com.example.banco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val FORM_INSERIR = 1
    private lateinit var lvPessoas: ListView
    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.lvPessoas = findViewById(R.id.lvMainPessoas)
        this.dao = PessoaDAO(this)

        fab.setOnClickListener { view ->
            val itForm = Intent(this, FormActivity::class.java)
            startActivityForResult(itForm, FORM_INSERIR)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORM_INSERIR){
                val p = data?.getSerializableExtra("PESSOA") as Pessoa
                Log.i("APP_BANCO", "Pessoa: ${p.nome}")

                this.dao.insert(p)
                Log.e("APP_BANCO", this.dao.get().toString())
            }
        }

    }

}
