package ru.blogspot.feomatr.lab.words.model

import java.awt.event.ActionEvent
import java.awt.event.ActionListener

/**
 * TODO: comment
 * @author iipolovinkin
 * @since 16.03.2016
 */
class ResolverModelImplNew : ResolverModel {

    private val map: MutableMap<String, String> = mutableMapOf();
    private val listeners: MutableList<ActionListener> = mutableListOf();
    private var words: MutableList<String> = mutableListOf();
    private var index: Int = -1;

    override fun addListener(l: ActionListener?) {
        l ?: return
        listeners.add(l)
    }

    override fun start() {
        index = 0
        publishCurrentWord()
    }

    private fun publishCurrentWord() {
        var s: String? = null
        var cmd: String
        if (index > -1 && index < words.size) {
            s = words[index]
            cmd = "update"
        } else {
            cmd = "map"
        }
        val event = ActionEvent(this, index, cmd)
        for (listener in listeners) {
            listener.actionPerformed(event)
        }
    }

    override fun finish() {
        index = 0
        publishCurrentWord()
    }

    override fun markCurrentWord(key: String?) {
        val word = currentWord ?: return
        if ("1" == key || "2" == key) {
            map.put(word, key) ?: return

            index++
            publishCurrentWord()
        }
    }

    override fun getMap(): MutableMap<String, String>? {
        return map
    }

    override fun getCurrentWord(): String? {
        if (index > -1 && words.size > index) {
            return words[index]
        }
        return null
    }

    override fun setWords(words: MutableList<String>?) {
        this.words = words!!
    }
}