package com.example.lab1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.lab1.R

class FragmentAnimation : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animation, container, false)

        val imageViewCat = view.findViewById<ImageView>(R.id.imageView)

        val buttonRotate = view.findViewById<Button>(R.id.buttonRotate)
        val buttonAlpha = view.findViewById<Button>(R.id.buttonAlpha)
        val buttonTranslate = view.findViewById<Button>(R.id.buttonTranslate)
        val buttonScale = view.findViewById<Button>(R.id.buttonScale)

        val animRotate = AnimationUtils.loadAnimation(context, R.anim.rotate)
        val animAlpha = AnimationUtils.loadAnimation(context, R.anim.alpha)
        val animTranslate = AnimationUtils.loadAnimation(context, R.anim.translate)
        val animScale = AnimationUtils.loadAnimation(context, R.anim.scale)


        buttonRotate.setOnClickListener {
            imageViewCat.startAnimation(animRotate)
        }

        buttonAlpha.setOnClickListener {
            imageViewCat.startAnimation(animAlpha)
        }

        buttonTranslate.setOnClickListener {
            imageViewCat.startAnimation(animTranslate)
        }

        buttonScale.setOnClickListener {
            imageViewCat.startAnimation(animScale)
        }

        return view
    }

}