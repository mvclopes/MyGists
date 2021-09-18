package br.com.mvclopes.mygists

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import br.com.mvclopes.mygists.model.GistItem
import com.bumptech.glide.Glide

@BindingAdapter("nameOwnerGist")
fun bindNameOwnerGist(txtView: TextView, gistItem: GistItem){
    gistItem?.let {
        txtView.text = it.owner.login
    }
}

@BindingAdapter("typeGist")
fun bindTypeGist(txtView: TextView, gistItem: GistItem){
    gistItem?.let {
        txtView.text = it.files.file.type
    }
}

@BindingAdapter("imgUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imageUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imageUri)
            .into(imgView)
    }
}