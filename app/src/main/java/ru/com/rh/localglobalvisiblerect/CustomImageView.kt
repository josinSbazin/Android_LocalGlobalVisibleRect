package ru.com.rh.localglobalvisiblerect

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.os.Parcelable
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.ImageView

class CustomImageView : ImageView {
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private var cachedRect = Rect()


    private fun check() {
        val isVisible = getGlobalVisibleRect(cachedRect)
        if (isVisible) {
            val trace = Exception().stackTrace
            val name = trace[1].methodName
            Log.d("CustomImageView", "$name: h = ${cachedRect.height()}, w = ${cachedRect.width()}")
        }
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        check()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        check()
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        check()
        return super.onCreateDrawableState(extraSpace)

    }

    override fun onStartTemporaryDetach() {
        super.onStartTemporaryDetach()
        check()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        check()
        return super.onTouchEvent(event)
    }

    override fun onKeyShortcut(keyCode: Int, event: KeyEvent?): Boolean {
        check()
        return super.onKeyShortcut(keyCode, event)
    }

    override fun onFinishInflate() {
        check()
        super.onFinishInflate()
    }

    override fun onSetAlpha(alpha: Int): Boolean {
        check()
        return super.onSetAlpha(alpha)
    }

    override fun onVisibilityAggregated(isVisible: Boolean) {
        super.onVisibilityAggregated(isVisible)
        check()
    }

    override fun onPopulateAccessibilityEvent(event: AccessibilityEvent?) {
        super.onPopulateAccessibilityEvent(event)
        check()
    }

    override fun onAnimationEnd() {
        super.onAnimationEnd()
        check()
    }

    override fun onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents()
        check()
    }

    override fun onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach()
        check()
    }

    override fun onResolvePointerIcon(event: MotionEvent?, pointerIndex: Int): PointerIcon {
        check()
        return super.onResolvePointerIcon(event, pointerIndex)
    }

    override fun onAnimationStart() {

        super.onAnimationStart()
        check()

    }

    override fun onProvideAutofillVirtualStructure(structure: ViewStructure?, flags: Int) {
        super.onProvideAutofillVirtualStructure(structure, flags)
        check()

    }

    override fun onCreateContextMenu(menu: ContextMenu?) {
        super.onCreateContextMenu(menu)
        check()

    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        check()

    }

    override fun onRtlPropertiesChanged(layoutDirection: Int) {
        super.onRtlPropertiesChanged(layoutDirection)
        check()

    }

    override fun onProvideStructure(structure: ViewStructure?) {
        super.onProvideStructure(structure)
        check()

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        check()

    }

    override fun onCapturedPointerEvent(event: MotionEvent?): Boolean {
        check()

        return super.onCapturedPointerEvent(event)

    }

    override fun onSaveInstanceState(): Parcelable {
        check()

        return super.onSaveInstanceState()
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection {
        check()

        return super.onCreateInputConnection(outAttrs)
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        check()

    }

    override fun onDragEvent(event: DragEvent?): Boolean {
        check()

        return super.onDragEvent(event)
    }

    override fun onApplyWindowInsets(insets: WindowInsets?): WindowInsets {
        check()

        return super.onApplyWindowInsets(insets)
    }

    override fun onTrackballEvent(event: MotionEvent?): Boolean {
        check()

        return super.onTrackballEvent(event)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        check()

    }

    override fun onHoverChanged(hovered: Boolean) {
        super.onHoverChanged(hovered)
        check()

    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        check()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        check()

        return super.onKeyDown(keyCode, event)
    }

    override fun onHoverEvent(event: MotionEvent?): Boolean {
        check()

        return super.onHoverEvent(event)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        check()

    }

    override fun onInitializeAccessibilityEvent(event: AccessibilityEvent?) {
        super.onInitializeAccessibilityEvent(event)
        check()

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        check()

    }

    override fun onOverScrolled(scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY)
        check()

    }

    override fun onFilterTouchEventForSecurity(event: MotionEvent?): Boolean {
        check()

        return super.onFilterTouchEventForSecurity(event)
    }

    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
        check()

    }

    override fun onCheckIsTextEditor(): Boolean {
        check()

        return super.onCheckIsTextEditor()
    }

    override fun onDisplayHint(hint: Int) {
        super.onDisplayHint(hint)
        check()

    }

    override fun onScreenStateChanged(screenState: Int) {
        super.onScreenStateChanged(screenState)
        check()

    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        check()

    }

    override fun onPointerCaptureChange(hasCapture: Boolean) {
        super.onPointerCaptureChange(hasCapture)
        check()

    }

    override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent?): Boolean {
        check()

        return super.onKeyMultiple(keyCode, repeatCount, event)
    }

    override fun onWindowSystemUiVisibilityChanged(visible: Int) {
        super.onWindowSystemUiVisibilityChanged(visible)
        check()

    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        check()

    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        check()

        return super.onKeyLongPress(keyCode, event)
    }

    override fun onProvideAutofillStructure(structure: ViewStructure?, flags: Int) {
        super.onProvideAutofillStructure(structure, flags)
        check()

    }

    override fun onGenericMotionEvent(event: MotionEvent?): Boolean {
        check()

        return super.onGenericMotionEvent(event)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        check()

    }

    override fun onProvideVirtualStructure(structure: ViewStructure?) {
        super.onProvideVirtualStructure(structure)
        check()

    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        check()

    }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        check()

        return super.onKeyPreIme(keyCode, event)
    }

    override fun onVisibilityChanged(changedView: View?, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        check()

    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        check()

        return super.onKeyUp(keyCode, event)
    }
}