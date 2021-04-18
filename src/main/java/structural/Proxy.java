package structural;

/**
 * Proxy replaces the real object and controls access to it.
 * <br/>
 * <br/>
 * Прокси заменяет реальный объект и контролирует доступ к нему.
 * */
public class Proxy {
    public static void main(String[] args) {

        WebCamera webCamera = new WebCamera();

        //try to use all webcam functions from user account
        System.out.println("Using common user webcam...");
        IWebCamera commonUserWebCam = new WebCameraCommonUserProxy(webCamera);
        System.out.println(commonUserWebCam.isTurnedOn());
        commonUserWebCam.turnOn();
        commonUserWebCam.turnLeft();
        commonUserWebCam.turnRight();
        commonUserWebCam.watchOnline();
        commonUserWebCam.turnOff();

        System.out.println();

        //try to use all webcam functions from admin account
        System.out.println("Using admin user webcam...");
        IWebCamera adminUserWebCam = new WebCameraAdminProxy(webCamera);
        System.out.println(adminUserWebCam.isTurnedOn());
        adminUserWebCam.turnOn();
        adminUserWebCam.turnLeft();
        adminUserWebCam.turnRight();
        adminUserWebCam.watchOnline();
        adminUserWebCam.turnOff();
        //try to watch webcam even if it is off
        adminUserWebCam.watchOnline();
    }
}

interface IWebCamera {
    void turnOn();
    void turnOff();
    void turnLeft();
    void turnRight();
    void watchOnline();
    boolean isTurnedOn();
}

class WebCamera implements IWebCamera {

    private boolean turnedOn;

    @Override
    public void turnOn() {
        this.turnedOn = true;
        System.out.println("WebCam is turned on!");
    }

    @Override
    public void turnOff() {
        this.turnedOn = false;
        System.out.println("WebCam is turned off!");
    }

    @Override
    public void turnLeft() {
        System.out.println("WebCam is turned left!");
    }

    @Override
    public void turnRight() {
        System.out.println("WebCam is turned right!");
    }

    @Override
    public void watchOnline() {
        System.out.println("WebCam watching...");
    }

    @Override
    public boolean isTurnedOn() {
        return turnedOn;
    }
}

class WebCameraCommonUserProxy extends WebCamera {

    private final WebCamera realWebCamera;

    public WebCameraCommonUserProxy(WebCamera realWebCamera) {
        this.realWebCamera = realWebCamera;
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on: Permission denied!");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off: Permission denied!");
    }

    @Override
    public void turnLeft() {
        System.out.println("Turn left: Permission denied!");
    }

    @Override
    public void turnRight() {
        System.out.println("Turn right: Permission denied!");
    }

    @Override
    public void watchOnline() {
        if (realWebCamera.isTurnedOn()) {
            realWebCamera.watchOnline();
        } else {
            System.out.println("Can't watch - webcam is turned off!");
        }
    }

    @Override
    public boolean isTurnedOn() {
        return realWebCamera.isTurnedOn();
    }
}

class WebCameraAdminProxy extends WebCamera {

    private final WebCamera realWebCamera;

    public WebCameraAdminProxy(WebCamera realWebCamera) {
        this.realWebCamera = realWebCamera;
    }

    @Override
    public void turnOn() {
        realWebCamera.turnOn();
    }

    @Override
    public void turnOff() {
        realWebCamera.turnOff();
    }

    @Override
    public void turnLeft() {
        realWebCamera.turnLeft();
    }

    @Override
    public void turnRight() {
        realWebCamera.turnRight();
    }

    @Override
    public void watchOnline() {
        if (!realWebCamera.isTurnedOn()) {
            realWebCamera.turnOn();
        }
        realWebCamera.watchOnline();
    }

    @Override
    public boolean isTurnedOn() {
        return realWebCamera.isTurnedOn();
    }
}
