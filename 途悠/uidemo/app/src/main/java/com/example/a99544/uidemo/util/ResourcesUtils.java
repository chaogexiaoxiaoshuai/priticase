package com.example.a99544.uidemo.util;

import android.content.Context;
import android.util.Log;

import com.example.a99544.uidemo.R;
import java.lang.reflect.Field;

/**
 * Created by 99544 on 2017/10/23.
 */

public class ResourcesUtils {


        private static final String RES_ID = "id";
        private static final String RES_STRING = "string";
        private static final String RES_DRABLE = "drable";
        private static final String RES_LAYOUT = "layout";
        private static final String RES_STYLE = "style";
        private static final String RES_COLOR = "color";
        private static final String RES_DIMEN = "dimen";
        private static final String RES_ANIM = "anim";
        private static final String RES_MENU = "menu";


        /**
         * 获取资源文件的id
         * @param context
         * @param resName
         * @return
         */
        public static int getId(Context context,String resName){
            return getResId(context,resName,RES_ID);
        }

        /**
         * 获取资源文件string的id
         * @param context
         * @param resName
         * @return
         */
        public static int getStringId(Context context,String resName){
            return getResId(context,resName,RES_STRING);
        }

        /**
         * 获取资源文件drable的id
         * @param context
         * @param resName
         * @return
         */
        public static int getDrableId(Context context,String resName){
            Class drawable  =  R.drawable.class;
            Field field = null;
            int r_id ;
            try {
                field = drawable.getField(resName);

                r_id = field.getInt(field.getName());
            } catch (Exception e) {
                r_id=0;
                Log.e("ERROR", "PICTURE NOT　FOUND！");
            }
            return r_id;
            //return getResId(context,resName,RES_DRABLE);
        }

        /**
         * 获取资源文件layout的id
         * @param context
         * @param resName
         * @return
         */
        public static int getLayoutId(Context context,String resName){
            return getResId(context,resName,RES_LAYOUT);
        }

        /**
         * 获取资源文件style的id
         * @param context
         * @param resName
         * @return
         */
        public static int getStyleId(Context context,String resName){
            return getResId(context,resName,RES_STYLE);
        }

        /**
         * 获取资源文件color的id
         * @param context
         * @param resName
         * @return
         */
        public static int getColorId(Context context,String resName){
            return getResId(context,resName,RES_COLOR);
        }

        /**
         * 获取资源文件dimen的id
         * @param context
         * @param resName
         * @return
         */
        public static int getDimenId(Context context,String resName){
            return getResId(context,resName,RES_DIMEN);
        }

        /**
         * 获取资源文件ainm的id
         * @param context
         * @param resName
         * @return
         */
        public static int getAnimId(Context context,String resName){
            return getResId(context,resName,RES_ANIM);
        }

        /**
         * 获取资源文件menu的id
         */
        public static int getMenuId(Context context,String resName){
            return getResId(context,resName,RES_MENU);
        }

        /**
         * 获取资源文件ID
         * @param context
         * @param resName
         * @param defType
         * @return
         */
        public static int getResId(Context context, String resName, String defType){
            return context.getResources().getIdentifier(resName, defType, context.getPackageName());
        }




}
