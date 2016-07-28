package com.LilG.Com.DataClasses;

import com.LilG.Com.DND.DNDPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ggonz on 11/25/2015.
 * Simple data class
 */
public class SaveDataStore {
    @NotNull
    private LinkedList<Note> noteList = new LinkedList<>();
    @NotNull
    private LinkedList<String> authedUser = new LinkedList<>();
    @NotNull
    private LinkedList<Integer> authedUserLevel = new LinkedList<>();
    @NotNull
    private String avatarLink = "http://puu.sh/oiLvW.gif";
    @NotNull
    private TreeMap<String, Meme> memes = new TreeMap<>();
    @NotNull
    private TreeMap<String, String> FCList = new TreeMap<>();
    @NotNull
    private LinkedList<String> DNDJoined = new LinkedList<>();
    @NotNull
    private LinkedList<DNDPlayer> DNDList = new LinkedList<>();
    @NotNull
    private HashMap<String, HashMap<String, ArrayList<String>>> allowedCommands = new HashMap<>();
    @NotNull
    private ConcurrentHashMap<String, LinkedList<String>> markovChain = new ConcurrentHashMap<>();


    public SaveDataStore(@NotNull LinkedList<String> authedUser, @NotNull LinkedList<Integer> authedUserLevel, @NotNull LinkedList<String> DNDJoined, @NotNull LinkedList<DNDPlayer> DNDList, @NotNull LinkedList<Note> noteList, @NotNull String avatarLink, @NotNull TreeMap<String, Meme> memes, @NotNull TreeMap<String, String> FCList, @NotNull ConcurrentHashMap<String, @NotNull LinkedList<String>> markovChain, @NotNull HashMap<String, HashMap<String, ArrayList<String>>> allowedCommands) {
        if (authedUser != null)
            this.authedUser = authedUser;
        if (authedUserLevel != null)
            this.authedUserLevel = authedUserLevel;
        if (DNDJoined != null)
            this.DNDJoined = DNDJoined;
        if (DNDList != null)
            this.DNDList = DNDList;
        if (noteList != null)
            this.noteList = noteList;
        if (avatarLink != null)
            this.avatarLink = avatarLink;
        if (memes != null)
            this.memes = memes;
        if (FCList != null)
            this.FCList = FCList;
        if (markovChain != null)
            this.markovChain = markovChain;
        if (allowedCommands != null)
            this.allowedCommands = allowedCommands;
    }

    @NotNull
    public ConcurrentHashMap<String, LinkedList<String>> getMarkovChain() {
        // Create the first two entries (k:_start, k:_end)
        if (markovChain.isEmpty()) {
            markovChain.put("_start", new LinkedList<>());
            markovChain.put("_end", new LinkedList<>());
        }
        return markovChain;
    }

    @NotNull
    public LinkedList<Note> getNoteList() {
        return noteList;
    }

    @NotNull
    public LinkedList<String> getAuthedUser() {
        return authedUser;
    }

    @NotNull
    public LinkedList<Integer> getAuthedUserLevel() {
        return authedUserLevel;
    }

    @NotNull
    public LinkedList<String> getDNDJoined() {
        return DNDJoined;
    }

    @NotNull
    public LinkedList<DNDPlayer> getDNDList() {
        return DNDList;
    }

    @NotNull
    public String getAvatarLink() {
        return avatarLink;
    }

    @NotNull
    public TreeMap<String, Meme> getMemes() {
        return memes;
    }

    @NotNull
    public TreeMap<String, String> getFCList() {
        return FCList;
    }

    @NotNull
    public HashMap<String, HashMap<String, ArrayList<String>>> getAllowedCommands() {
        if (allowedCommands == null) {
            allowedCommands = new HashMap<>();
        }
        if (allowedCommands.isEmpty()) {
            HashMap<String, ArrayList<String>> temp = new HashMap<>();
            temp.put("#retro", new ArrayList<>(Arrays.asList("GayDar", "url checker")));
            temp.put("#origami64", new ArrayList<>(Arrays.asList("markov", "my", "url checker")));
            allowedCommands.put("BadnikZONE", temp);
            temp = new HashMap<>();
            temp.put("#deltasmash", new ArrayList<>(Arrays.asList("FC", "version")));
            allowedCommands.put("twitch", temp);
            temp = new HashMap<>();
            temp.put("#pmd", new ArrayList<>(Collections.singletonList("url checker")));
            allowedCommands.put("CaffieNET", temp);
            temp = new HashMap<>();
            temp.put("#general", new ArrayList<>(Collections.singletonList("url checker")));
            temp.put("#development", new ArrayList<>(Collections.singletonList("url checker")));
            allowedCommands.put("Discord Bots", temp);
        }
        return allowedCommands;
    }
}
