/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
*
* @author Meowcake
*/

public class RepoFactory {

     public static IRepo GetRepo(int repoType)
    {
        switch (repoType)
        {
        case 1:
            return (IRepo) new Repo();
        default:
            return null;
        }
    }
}
