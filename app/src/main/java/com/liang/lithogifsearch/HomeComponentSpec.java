package com.liang.lithogifsearch;

import android.util.Log;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Binder;
import com.facebook.litho.widget.EditText;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.TextChangedEvent;

@LayoutSpec
class HomeComponentSpec {
    private static final String TAG = "HomeComponentSpec";
    @OnCreateLayout
    static Component OnCreateLayout(
            ComponentContext c,
            @Prop Binder binder,
            @Prop String hint) {
        Log.d(TAG, "OnCreateLayout: starts");

        return Column.create(c)
                .child(editTextComponent123(c, hint))
                .child(recyclerComponent123(c, binder))
                .build();
    }

    private static Component editTextComponent123 (
            ComponentContext c,
            String hint) {
        Log.d(TAG, "editTextComponent123: ");
        return EditText.create(c)
                .textSizeDip(20)
                .textChangedEventHandler(HomeComponent.onQueryChanged(c))
                .hint(hint)
                .build();
    }
//    https://fblitho.com/docs/recycler-component#recyclerbinder
    private static Component recyclerComponent123 (ComponentContext c, Binder binder) {
        Log.d(TAG, "recyclerComponent123:");

//        binder.appendItem(GifItemView.create(c).build());

        return Recycler.create(c)
                .binder(binder)
                .build();

    }

    @OnEvent(TextChangedEvent.class)
    static void onQueryChanged(ComponentContext c, @Prop OnQueryUpdateListener listener, @FromEvent String text) {
        Log.d(TAG, "onQueryChanged: " + text);
        listener.onQueryUpdate(text);
    }


    public interface OnQueryUpdateListener{
        void onQueryUpdate(String query);
    }
}
