package com.example.iancu.asosclothes.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Iancu on 16/10/2016.
 */

public class RxUtils {
    public static void unsubscribeIfNotNull(Subscription subscription) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public static CompositeSubscription getNewCompositeSubIfUnsubscribed(CompositeSubscription subscription) {
        if (subscription == null || subscription.isUnsubscribed()) {
            return new CompositeSubscription();
        }

        return subscription;
    }
}
