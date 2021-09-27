package com.gustavothirion.githubdatarepositories.adapter

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gustavothirion.githubdatarepositories.R
import com.gustavothirion.githubdatarepositories.model.Item
import com.wajahatkarim3.easyflipview.EasyFlipView

class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val repositoryPhoto: ImageView = view.findViewById(R.id.repository_photo)
    private val repositoryName: TextView = view.findViewById(R.id.repository_content)
    private val repositoryDescription: TextView = view.findViewById(R.id.description_content)
    private val repositoryAuthor: TextView = view.findViewById(R.id.author_content)
    private val repositoryStars: TextView = view.findViewById(R.id.stars_content)
    private val repositoryForks: TextView = view.findViewById(R.id.forks_content)
    private val flipView: EasyFlipView = view.findViewById(R.id.flip_view)
    private val buttonViewFront: Button = view.findViewById(R.id.description_btn)
    private val buttonViewBack: Button = view.findViewById(R.id.back_btn)

    fun bind(item: Item) {
        Glide.with(itemView.context).load(item.owner.avatar_url).into(repositoryPhoto)
        repositoryName.text = item.name
        repositoryDescription.text = item.description
        repositoryAuthor.text = item.owner.login
        repositoryStars.text = item.stargazers_count.toString()
        repositoryForks.text = item.forks_count.toString()
    }

    init {
        flipView.setToHorizontalType()

        buttonViewFront.setOnClickListener {
            flipView.flipTheView()
        }
        buttonViewBack.setOnClickListener {
            flipView.flipTheView()
        }
    }

    fun clearAnimation() {
        val backVal: Boolean = flipView.isBackSide
        if (backVal) {
            flipView.flipTheView()
        }
    }
}
