package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quiz.constants.getque
import java.lang.NullPointerException

class quescreen : AppCompatActivity(),View.OnClickListener {

    private var mcurrentpos: Int=1
    private var mquelist:ArrayList<Question>?=null
    private var mselectedoption: Int =0
    private var musername : String? =null
    private var mcorrectans: Int =0

    private var progressBar : ProgressBar? =null
    private var tvprogress : TextView? =null
    private var tvque :TextView? =null
    private var tvImage : ImageView? =null

    private var tvopt1 : TextView? =null
    private var tvopt2 : TextView? =null
    private var tvopt3 : TextView? =null
    private var tvopt4 : TextView? =null

    private var btnsbmt: Button?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quescreen)
        musername=intent.getStringExtra(constants.USER_NAME)

        progressBar=findViewById(R.id.tv_bar)
        tvprogress=findViewById(R.id.tv_textbar)
        tvque=findViewById(R.id.tv_que)
        tvImage=findViewById(R.id.tv_image)
        tvopt1=findViewById(R.id.tv_opt1)
        tvopt2=findViewById(R.id.tv_opt2)
        tvopt3=findViewById(R.id.tv_opt3)
        tvopt4=findViewById(R.id.tv_opt4)
        btnsbmt=findViewById(R.id.tv_btn)
        mquelist = getque()



        setquetionss()
        tvopt1?.setOnClickListener(this)
        tvopt2?.setOnClickListener(this)
        tvopt3?.setOnClickListener(this)
        tvopt4?.setOnClickListener(this)
        btnsbmt?.setOnClickListener(this)
    }

    private fun setquetionss() {
        defaultoptionview()
        val question: Question = mquelist!![mcurrentpos - 1]

        tvImage?.setImageResource(question.img)
        progressBar?.progress = mcurrentpos
        tvprogress?.text = "$mcurrentpos/${progressBar?.max}"
        tvque?.text = question.ques
        tvopt1?.text = question.optionone
        tvopt2?.text = question.optiontwo
        tvopt3?.text = question.optithree
        tvopt4?.text = question.optionfour
        btnsbmt?.text="SUBMIT"


    }

    private fun defaultoptionview(){
        val options= ArrayList<TextView>()

        tvopt1?.let{
            options.add(0,it)
        }
        tvopt2?.let{
            options.add(1,it)
        }
        tvopt3?.let{
            options.add(2,it)
        }
        tvopt4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this,
                R.drawable.default_option_border)
        }

    }
    private fun selectedoptionview(tv:TextView,selectedoptnum: Int){
        defaultoptionview()
        mselectedoption=selectedoptnum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.selected_option_border)
    }



    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_opt1->{
                tvopt1?.let {
                    selectedoptionview(it,1)
                }
            }
            R.id.tv_opt4->{
                tvopt4?.let {
                    selectedoptionview(it,4)
                }
            }
            R.id.tv_opt3->{
                tvopt3?.let {
                    selectedoptionview(it,3)
                }
            }
            R.id.tv_opt2->{
                tvopt2?.let {
                    selectedoptionview(it,2)
                }
            }
            R.id.tv_btn->{
                if(mselectedoption==0){
                    mcurrentpos++;

                when{mcurrentpos<=mquelist!!.size-> {
                    setquetionss()
                }
                    else-> {
                        intent = Intent(this,resultactivity::class.java)
                        intent.putExtra(constants.USER_NAME,musername)
                        intent.putExtra(constants.CORRECT_ANS,mcorrectans)
                        intent.putExtra(constants.TOTAL_QUE,mquelist!!.size)
                        startActivity(intent)
                        finish()
                    }

                }}
                else{
                    val question1 =mquelist?.get(mcurrentpos-1)
                    if(question1!!.correctoption!=mselectedoption){
                        answerview(mselectedoption,R.drawable.wrong_option_border)
                    }else{
                        mcorrectans++
                    }
                    answerview(question1.correctoption,R.drawable.correct_option_border)

                    if(mcurrentpos == mquelist!!.size){
                        btnsbmt?.text="FINISH"
                    }
                    else
                    {
                        btnsbmt?.text="NEXT QUESTION"
                    }

                    mselectedoption=0
                }
            }


        }

    }


    private fun answerview(ans: Int, Draw: Int){
        when(ans){
            1->{
                tvopt1?.background=ContextCompat.getDrawable(this,Draw)
            }
            2->{
                tvopt2?.background=ContextCompat.getDrawable(this,Draw)
            }
            3->{
                tvopt3?.background=ContextCompat.getDrawable(this,Draw)
            }
            4->{
                tvopt4?.background=ContextCompat.getDrawable(this,Draw)
            }
        }

    }



}