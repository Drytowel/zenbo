package com.robot.asus.ZenboHelloWorld;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.asus.robotframework.API.MotionControl;
import com.asus.robotframework.API.RobotCallback;
import com.asus.robotframework.API.RobotCmdState;
import com.asus.robotframework.API.RobotCommand;
import com.asus.robotframework.API.RobotErrorCode;
import com.asus.robotframework.API.RobotFace;
import com.robot.asus.robotactivity.RobotActivity;

import org.json.JSONObject;

public class MainActivity extends RobotActivity {

    private static int s;
    private static boolean active;

    public static RobotCallback robotCallback = new RobotCallback() {
        @Override
        public void onResult(int cmd, int serial, RobotErrorCode err_code, Bundle result) {
            super.onResult(cmd, serial, err_code, result);
            Log.d("RobotDevSample", "onResult:"
                    + RobotCommand.getRobotCommand(cmd).name()
                    + ", serial:" + serial + ", err_code:" + err_code
                    + ", result:" + result.getString("RESULT"));
        }

        @Override
        public void onStateChange(int cmd, int serial, RobotErrorCode err_code, RobotCmdState state) {
                    super.onStateChange(cmd, serial, err_code, state);
                    if(s == serial){
                        robotAPI.robot.speak("serial is " + String.valueOf(serial));
//                robotAPI.robot.speak("state is " + String.valueOf(state));
//                robotAPI.robot.speak(String.valueOf(String.valueOf(state).indexOf("SUCCEED")));
                        if(String.valueOf(state).indexOf("ROBOT_CMD_STATE_SUCCEED") != -1){
                            robotAPI.robot.speak("SUCCEED");
                            active = true;
//                            robotAPI.robot.speak("hello");
                        }
                        robotAPI.robot.speak(RobotCommand.getRobotCommand(cmd).name());

            }

        }

        @Override
        public void initComplete() {
            super.initComplete();

        }
    };

    public static RobotCallback.Listen robotListenCallback = new RobotCallback.Listen() {
        @Override
        public void onFinishRegister() {

        }

        @Override
        public void onVoiceDetect(JSONObject jsonObject) {

        }

        @Override
        public void onSpeakComplete(String s, String s1) {

        }

        @Override
        public void onEventUserUtterance(JSONObject jsonObject) {

        }

        @Override
        public void onResult(JSONObject jsonObject) {

        }

        @Override
        public void onRetry(JSONObject jsonObject) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public MainActivity() {
        super(robotCallback, robotListenCallback);
    }

    @Override
    protected void onResume() {
        int intCmdID, i;
        super.onResume();
        active = true;

//        robotAPI.motion.moveBody(3, 0, 45);
//        robotAPI.robot.speak("前往黑暗領土");
//        robotAPI.motion.goTo("黑暗領土", true);
//        robotAPI.robot.speak("前往別人家");
//        robotAPI.motion.goTo("別人家", true);

//        int pos;
//        pos = robotAPI.slam.activeLocalization();
//        robotAPI.robot.speak(String.valueOf(pos));

//         robotAPI.robot.speak("移動1");
//        robotAPI.motion.moveBody(1, 1, 0, MotionControl.SpeedLevel.Body.L7);
//        robotAPI.robot.setExpression(RobotFace.HELPLESS, "啾啾我");
//        robotAPI.robot.speak("移動2");
//        robotAPI.motion.moveBody(-1, -1, 0, MotionControl.SpeedLevel.Body.L7);

//        robotAPI.robot.speak("這裡是黑暗領土呵呵呵");

//        robotAPI.robot.speak("這裡是別人家，我們要安靜一點喔");
//        robotAPI.robot.speak("我累了，要回家休息了");
//        robotAPI.motion.goTo("Zenbo");
//        s = robotAPI.motion.goTo("別人家");

//        s = robotAPI.motion.moveBody(1, 0, 0);

//        while(true){
////            if(active == true){
////                s = robotAPI.motion.moveBody(1, 0, 0);
////                robotAPI.robot.speak("move body is " + String.valueOf(s));
////                break;
////            }else if(active == false){
////                s = robotAPI.robot.speak("hello");
////                robotAPI.robot.speak("speak is " + String.valueOf(s));
////            }
////        }

//        s = robotAPI.robot.speak("hello");
//        robotAPI.robot.speak("speak is " + String.valueOf(s));
//        active = false;

//        robotAPI.robot.speak("active is " + active);
//
//        s = robotAPI.motion.moveBody(1, 0, 0);
//        robotAPI.robot.speak("move body is " + String.valueOf(s));





//        robotAPI.motion.remoteControlBody(MotionControl.Direction.Body.BACKWARD);
//        robotAPI.motion.stopMoving();

        active1();
        if(active == true){
            active2();
        }

    }



    public void bt_change_onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this , SecondActivity.class);
        startActivity(intent);
    }

    public void active1(){
        active = false;
        s = robotAPI.robot.speak("嗨囉");
    }

    public void active2(){
        s = robotAPI.motion.moveBody(1,0,0);
    }
}
