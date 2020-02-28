<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single" >
        <item android:icon="@android:drawable/ic_menu_edit"
            android:id="@+id/nav_notes"
            android:checked="true"
            android:title="@string/notes">
        </item>

        <item android:icon="@android:drawable/ic_popup_reminder"
            android:id="@+id/nav_notification"
            android:title="@string/notification">
        </item>

        <item android:icon="@android:drawable/ic_input_get"
            android:id="@+id/nav_archive"
            android:title="@string/archive">
        </item>

        <item android:icon="@android:drawable/ic_menu_delete"
            android:id="@+id/nav_basket"
            android:title="@string/basket">
        </item>
    </group>

    <item >
        <menu>
            <item android:icon="@android:drawable/ic_menu_manage"
                android:id="@+id/nav_settings"
                android:title="@string/settings">
            </item>

            <item android:icon="@android:drawable/ic_menu_send"
                android:id="@+id/nav_feedback"
                android:title="@string/feedback">
            </item>
        </menu>
    </item>
</menu>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               