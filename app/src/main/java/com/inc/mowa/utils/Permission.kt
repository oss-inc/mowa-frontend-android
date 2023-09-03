package com.inc.mowa.utils

import android.content.Context
import androidx.core.app.NotificationManagerCompat

/**
 * Check alarm permission
 *
 * @author seonwoo
 */
fun getAlarmPermissionStatus(context: Context): Boolean {
    return NotificationManagerCompat.from(context).areNotificationsEnabled()
}
