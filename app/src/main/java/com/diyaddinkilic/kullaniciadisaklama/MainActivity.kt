package com.diyaddinkilic.kullaniciadisaklama

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.diyaddinkilic.kullaniciadisaklama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var alinanKulanıciAdi: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //   setContentView(R.layout.activity_main)


        //SharedPreferences
        sharedPreferences = this.getSharedPreferences(
            "com.diyaddinkilic.kullaniciadisaklama",
            MODE_PRIVATE
        )
        alinanKulanıciAdi = sharedPreferences.getString("Kullanici", "")
        if (alinanKulanıciAdi!=null){
            binding.textView.text="Kaydedilen kullanıcı adı:${alinanKulanıciAdi}"
        }
    }

    fun kaydet(view: View) {
        val kullaniciAdi = binding.editText.text.toString()
        if (kullaniciAdi == "") {
            Toast.makeText(this, "Lütfen Bir Değer Giriniz", Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("Kullanici", kullaniciAdi).apply()
            binding.textView.text = "Kaydedilen kullanıcı adı:${kullaniciAdi}"
        }
    }

    fun sil(view: View) {
alinanKulanıciAdi=sharedPreferences.getString("Kullanici","")
        if (alinanKulanıciAdi!=null){
            binding.textView.text="Kaydedilen kullanıcı adı:"
            sharedPreferences.edit().remove("Kullanici").apply()
        }
    }
}