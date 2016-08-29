package com.group.yztcedu.fblife.utils;


import android.hardware.Camera;
import android.hardware.Camera.Parameters;
/**
 * Created by Polaris on 2016/8/4.
 */
public class HardwareUtils {
    public static Camera camera;

    /**
     * 打开闪光灯
     */
    public static void OpenLightOn(){
        try{
            camera = Camera.open();
            camera.startPreview();
            Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);

        }catch (Exception e){

        }

    }

    /**
     * 关闭闪光灯
     */
    public static void CloseLightOff(){
        try {
            Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.release();
            camera = null;
        }catch (Exception e){

        }

    }
}
