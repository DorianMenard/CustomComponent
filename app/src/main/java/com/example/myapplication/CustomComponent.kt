package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.view_custom_component.view.*

class CustomComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_component, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_component_attributes, 0, 0)

            val str = typedArray.getString(R.styleable.custom_component_attributes_custom_component_text)?:resources.getString(R.string.component_one)
            my_edit.setText(str)

            val draw = typedArray.getDrawable(R.styleable.custom_component_attributes_custom_component_image)?:ResourcesCompat.getDrawable(resources, R.drawable.logo, null)
            my_image.setImageDrawable(draw)

            val color = typedArray.getColor(R.styleable.custom_component_attributes_custom_component_color, ResourcesCompat.getColor(resources, R.color.colorPrimary, null))
            my_edit.setTextColor(color)

            typedArray.recycle()
        }
    }

}