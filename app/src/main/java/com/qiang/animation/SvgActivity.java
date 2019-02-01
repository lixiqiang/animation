package com.qiang.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SvgActivity extends AppCompatActivity {

    @BindView(R.id.svg_image_view)
    SVGAImageView svgImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        SVGAParser parser = new SVGAParser(this);

//        resetDownloader(parser);
        URL url = null;
        try {
            url = new URL("https://github.com/yyued/SVGA-Samples/blob/master/posche.svga?raw=true");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // "test.svga"
        parser.parse(url, new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(@NotNull SVGAVideoEntity svgaVideoEntity) {
                SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                svgImageView.setImageDrawable(drawable);
                svgImageView.startAnimation();
            }

            @Override
            public void onError() {

            }
        });

    }


    private void resetDownloader(SVGAParser parser) {
        parser.setFileDownloader(new SVGAParser.FileDownloader() {
            @Override
            public void resume(final URL url, final Function1<? super InputStream, Unit> complete, final Function1<? super Exception, Unit> failure) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.connect();

                            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                                InputStream is = connection.getInputStream();
                                complete.invoke(is);
                            }

                            connection.disconnect();
                        } catch (IOException e) {
                            Log.e("resetDownloader", "e =" + e.toString());
                            e.printStackTrace();
                            failure.invoke(e);
                        }
                    }
                }).start();
            }
        });
    }
}
