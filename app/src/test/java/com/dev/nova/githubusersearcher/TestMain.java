package com.dev.nova.githubusersearcher;

import com.dev.nova.githubusersearcher.API.GithubRepo;
import com.dev.nova.githubusersearcher.API.GithubUser;

import org.junit.Assert;
import org.junit.Test;

public class TestMain {
    @Test
    public void testGitRepoItems(){
        GithubRepo githubRepo = new GithubRepo();
        if (githubRepo.getItems() == null){
            Assert.fail();
        }
    }

    @Test
    public void testGitUserItems(){
        GithubUser githubUser= new GithubUser();
        if (githubUser.getItems() == null){
            Assert.fail();
        }
    }

    @Test
    public void testBufferUser(){
        if (Buffer.user != null){
            Assert.fail();
        }
    }

    @Test
    public void testBufferRepo(){
        if (Buffer.repo != null){
            Assert.fail();
        }
    }
}
