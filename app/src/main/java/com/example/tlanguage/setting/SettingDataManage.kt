package com.example.tlanguage.setting

class SettingDataManage private constructor(){
    var autoSwapWords: Boolean? = null
    var repeatWords: Int? = null
    var autoSpeakWords: Boolean? = null

    private object Holder { val INSTANCE = SettingDataManage() }

    companion object {
        @JvmStatic
        fun getInstance(): SettingDataManage {
            return Holder.INSTANCE
        }
    }

    fun onUpdate(autoSwapWords: Boolean, repeatWords: Int, autoSpeakWords: Boolean) {
        this.autoSwapWords = autoSwapWords
        this.repeatWords = repeatWords
        this.autoSpeakWords = autoSpeakWords
    }

    override fun toString(): String {
        return "$autoSpeakWords $repeatWords $autoSwapWords"
    }


}