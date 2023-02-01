package com.example.memorygame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listImageOchiqYopiq = arrayOf(false, false, false, false, false, false)
            val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image1.setOnClickListener {

            imageClick(image1, android.R.drawable.btn_star, 0)
        }
        image2.setOnClickListener {
            imageClick(image2, android.R.drawable.checkbox_on_background, 1)
        }
        image3.setOnClickListener {
            imageClick(image3, android.R.drawable.ic_input_add, 2)
        }
        image4.setOnClickListener {

            imageClick(image4, android.R.drawable.btn_star, 3)
        }
        image5.setOnClickListener {
            imageClick(image5, android.R.drawable.checkbox_on_background, 4)
        }
        image6.setOnClickListener {
            imageClick(image6, android.R.drawable.ic_input_add, 5)
        }
    }
    fun imageClick(imageView: ImageView, rasm: Int, index: Int){
        if (!animationDoing){

        }
        if (listImageOchiqYopiq[index] == false){
            animationOchilishi(imageView, rasm, index)
        }else{
            animationYopilishi(imageView, rasm, index)
        }
    }
    fun animationOchilishi(imageView: ImageView, rasm: Int, index: Int) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object  : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImageOchiqYopiq[index] = true
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++
                        if (ochiqRasm== 2){
                            if (rasmId[0] == rasmId[1]){
                                imageViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                            }else{
                                animationYopilishi(imageViewAniqla(imageIndex[0]), -1, imageIndex[0])
                                animationYopilishi(imageViewAniqla(imageIndex[1]), -1, imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })
    }

            fun animationYopilishi(imageView: ImageView, rasm: Int, index: Int?) {
                val animation = AnimationUtils.loadAnimation(this, R.anim.anim1)
                imageView.startAnimation(animation)
                animation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {
                        animationDoing = true
                    }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.ic_baseline_wifi_24)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        listImageOchiqYopiq[index!!] = false
        ochiqRasm--

    }
    fun imageViewAniqla(index: Int?):ImageView{
        var imageView:ImageView? = null
        when(index){
            0 -> imageView = image1
            1 -> imageView = image2
            2 -> imageView = image3
            3 -> imageView = image4
            4 -> imageView = image5
            5 -> imageView = image6
        }
        return imageView!!
    }
}