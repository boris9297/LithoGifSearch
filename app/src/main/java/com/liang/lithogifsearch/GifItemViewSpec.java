package com.liang.lithogifsearch;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Size;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.utils.MeasureUtils;


//@LayoutSpec
@MountSpec
class GifItemViewSpec {
    private static final String TAG = "GifItemViewSpec";
//    @OnCreateLayout
//    static Component onCreateLayout(ComponentContext c
//            ,@Prop(optional = true) String gif_title
//            ,@Prop String gif_author
//            ) {
//        Log.d(TAG, "onCreateLayout");
//        return Column.create(c)
//                .paddingDip(YogaEdge.ALL,16)
//                .backgroundColor(Color.WHITE)
//                .child(
//                        Text.create(c)
//                        .textSizeSp(32)
//                        .text(gif_title))
//                .child(Text.create(c)
//                        .textSizeSp(16)
//                        .text(gif_author))
//                .build();
//    }


    @OnMeasure
    protected static void onMeasure(ComponentContext context,
            ComponentLayout layout,
            int widthSpec,
            int heightSpec,
            Size size) {
        MeasureUtils.measureWithDesiredPx(widthSpec, heightSpec, 48*3, 48*3, size);

    }

    @OnCreateMountContent
    protected static ImageView onCreateMountContent(Context c) {

        ImageView view = new ImageView(c.getApplicationContext());
        view.setBackgroundColor(Color.WHITE);
        view.setScaleType(ImageView.ScaleType.CENTER);
        view.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
}
