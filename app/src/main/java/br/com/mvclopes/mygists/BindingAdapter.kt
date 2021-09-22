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
        txtView.text = it.files[0].type
    }
}

@BindingAdapter("imgUrl")
fun bindImage(imgView: ImageView, gistItem: GistItem){
    val imgUrl = gistItem.owner.avatar_url
    imgUrl?.let {
        val imageUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imageUri)
            .into(imgView)
    }
}

@BindingAdapter("iconStar")
fun bindIconStar(imgView: ImageView, gistItem: GistItem){
    if (gistItem.isStarred){
        imgView.setImageResource(R.drawable.ic_star_full)
    }else{
        imgView.setImageResource(R.drawable.ic_star_border)
    }
}