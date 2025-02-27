package com.humber.customviewlab


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircularProgressView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var progress = 50

    private val paint = Paint().apply {
        isAntiAlias = true
        strokeWidth = 20f
        color = Color.BLUE
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (width / 2f) - 30

        // Draw background circle
        paint.color = Color.LTGRAY
        canvas.drawCircle(centerX, centerY, radius, paint)

        // Draw progress arc
        paint.color = Color.BLUE
        val sweepAngle = (progress / 100f) * 360
        canvas.drawArc(
            centerX - radius, centerY - radius,
            centerX + radius, centerY + radius,
            -90f, sweepAngle, false, paint
        )
    }

    fun setProgress(value: Int) {
        progress = value.coerceIn(0, 100)
        invalidate() // Redraw the view
    }
}