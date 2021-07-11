package com.company.designpattern.aop;

import com.company.designpattern.proxy.Html;
import com.company.designpattern.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    //Aop는 관점 지향이므로 상태를 이용한다.
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if(html == null){
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from : "+url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();

        System.out.println("BrowserProxy use cache html: "+url);
        return html;
    }
}
