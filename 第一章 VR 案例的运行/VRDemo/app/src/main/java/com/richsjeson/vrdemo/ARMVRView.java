// This proprietary software may be used only as
// authorised by a licensing agreement from ARM Limited
// (C) COPYRIGHT 2015 ARM Limited
// ALL RIGHTS RESERVED
// The entire notice above must be reproduced on all authorised
// copies and copies may only be made to the extent permitted
// by a licensing agreement from ARM Limited.
package com.richsjeson.vrdemo;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

class ARMVRView extends GLSurfaceView {
    private static final String TAG = "ARMVR";
    private static final boolean DEBUG = true;

    public ARMVRView(Context context) {
        super(context);
        setEGLConfigChooser(8, 8, 8, 0, 16, 0);
        setEGLContextClientVersion(2);
        setRenderer(new Renderer());
    }

    private static class Renderer implements GLSurfaceView.Renderer {
        public void onDrawFrame(GL10 gl) {
            ARMVR.step();
        }

        public void onSurfaceChanged(GL10 gl, int width, int height) {
            ARMVR.resize(width, height);
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            ARMVR.init();
        }
    }
}
