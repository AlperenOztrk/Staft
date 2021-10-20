package com.wiuma.staft.models

import com.wiuma.staft.MainActivity

class User {

    companion object {
        private const val userIDKey = "staftUserID"
        private const val sentMessageKey = "staftSentMessageCount"
        private const val receivedMessageKey = "staftReceivedMessageCount"

        fun userID(activity: MainActivity): String? {
            return activity.sharedPreferences.getString(userIDKey, null)
        }

        fun setUserID(activity: MainActivity, userID: String) {
            activity.sharedPreferences.edit().putString(userIDKey, userID).apply()
        }

        private fun sentCount(activity: MainActivity): Int {
            return activity.sharedPreferences.getInt(sentMessageKey, 0)
        }

        fun increaseSentCount(activity: MainActivity) {
            activity.sharedPreferences.edit().putInt(userIDKey, sentCount(activity) + 1).apply()
        }

        private fun receivedCount(activity: MainActivity): Int {
            return activity.sharedPreferences.getInt(receivedMessageKey, 0)
        }

        fun increaseReceivedCount(activity: MainActivity, userID: String) {
            activity.sharedPreferences.edit().putInt(userIDKey, receivedCount(activity) + 1).apply()
        }
    }
}