package Utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import javax.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by taow on 2017/8/15.
 */

public class HttpUtils {
    public void init(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.i("onfailure ..");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                LogUtils.i("onResponse res: "+res);
            }
        });


        /**
         * 1, 取消任务,底层调用的是socket.close();因为Http是基于传输层TCP/IP协议，
         * 握手过程中传送的包里不包含数据，三次握手完毕后，客户端与服务器才正式开始传送数据。
         * 理想状态下，TCP连接一旦建立，在通信双方中的任何一方主动关闭连接之前，
         * TCP 连接都将被一直保持下去。断开连接时服务器和客户端均可以主动发起断开TCP连接的请求，
         * 断开过程需要经过“四次握手”
         */

        call.cancel();

        //2, 设置代理
        int proxyPort = 8080;
        String proxyHost = "proxyHost";
        final String username = "username";
        final String password = "password";
        Authenticator proxyAuthenticator = new Authenticator() {
            @Nullable
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                String credential = Credentials.basic(username, password);
                return response.request().newBuilder()
                        .header("Proxy-Authorization", credential)
                        .build();
            }
        };

        okHttpClient.newBuilder().proxy(new Proxy(Proxy.Type.HTTP,
                new InetSocketAddress(proxyHost,proxyPort)));

        //3, post 文件上传
        File file = new File(Environment.getExternalStorageDirectory(), "balabala.mp4");
        RequestBody body = FormBody.create(MediaType.parse("application/octet-stream"),file);
        request.newBuilder().method("post",body);


    }
}
