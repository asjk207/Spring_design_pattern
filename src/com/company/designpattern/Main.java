package com.company.designpattern;

import com.company.designpattern.adapter.*;
import com.company.designpattern.aop.AopBrowser;
import com.company.designpattern.decorator.*;
import com.company.designpattern.facade.Ftp;
import com.company.designpattern.facade.Reader;
import com.company.designpattern.facade.SftpClient;
import com.company.designpattern.facade.Writer;
import com.company.designpattern.observer.Button;
import com.company.designpattern.observer.IButtonListener;
import com.company.designpattern.proxy.Browser;
import com.company.designpattern.proxy.BrowserProxy;
import com.company.designpattern.proxy.IBrowser;
import com.company.designpattern.singleton.AClazz;
import com.company.designpattern.singleton.BClazz;
import com.company.designpattern.singleton.SocketClient;
import com.company.designpattern.startegy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // base64
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        // Encoder의 구조는 변화하지 않으며, 전략 클래스만 변경하여 인자로 넘겨 줌으로써,
        // 다른 결과값을 얻을수 있다.
        encoder.setEncodingstrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingstrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingstrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}

// SingleTon Pattern Main
    /*
        public class Main {
            public static void main(String[] args) {
                AClazz aClazz = new AClazz();
                BClazz bClazz = new BClazz();

                SocketClient aClient = aClazz.getSocketClient();
                SocketClient bClient = bClazz.getSocketClient();

                System.out.println("두개의 객체가 동일한가?");
                System.out.println(aClient.equals(bClient));
            }
        }
     */

// Adapter Pattern Main
/*
    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        // cleaner는 220V객체를 받아야하므로 에러가 발생한다.
        Cleaner cleaner = new Cleaner();
        // 어댑터를 통해 자기자신의 구조는 변화시키지 않고, 인자로 받는 객체에 맞게 변환시키는 것을 어댑터 패턴이라 한다.
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
    }
    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
*/

// Proxy Pattern Main
/*
    public static void main(String[] args) {
        // Proxy를 통하지 않으면, 캐싱 되지 않고, 객체를 계속 해서 생성한다.
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
        // Proxy를 통하면, 생성된 객체를 이용한다.(캐싱)
//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        //aop 패턴을 이용하여 캐싱 전후의 상태에 따른 처리 작업이 가능하다.( 이해 완전히 하지 못하였음. )
        aopBrowser.show();
        System.out.println("loading time: "+end.get());
        aopBrowser.show();
        System.out.println("loading time: "+end.get());
    }
 */

// Decorator Pattern Main

/*
    public static void main(String[] args) {
        // ICar 인터페이스를 통해 아우디 객체를 생성한다.
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
    }
 */

// Observer Pattern Main
/*
    public static void main(String[] args) {
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            // clickEvent메소드가 발생하면 작동한다.
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달 : click");
        button.click("메시지 전달 : click");
        button.click("메시지 전달 : click");
        button.click("메시지 전달 : click");

    }
 */

// Pacade Pattern Main

/*

    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();
        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();
        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();
        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // 위의 facade pattern을 사용하기전 위의 사용법 대신 facade 패턴을 사용함으로써
        // 각각의 객체에 의존 하지 않고, 여러가지 의존성 메소드를 통합하여 새로운 인터페이스 형태로 제공한다.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();

    }
 */

// Strategy Pattern Main

/*

    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        // base64
        EncodingStrategy base64 = new Base64Strategy();

        // base64
        EncodingStrategy normal = new NormalStrategy();
        String message = "hello java";

        // Encoder의 구조는 변화하지 않으며, 전략 클래스만 변경하여 인자로 넘겨 줌으로써,
        // 다른 결과값을 얻을수 있다.
        encoder.setEncodingstrategy(base64);
        String base64Result = encoder.getMessage(message);

        System.out.println(base64Result);
        encoder.setEncodingstrategy(normal);

        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingstrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }

 */