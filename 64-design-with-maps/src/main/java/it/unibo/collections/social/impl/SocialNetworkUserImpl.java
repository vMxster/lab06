/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */
    private final static int DEFAULT_AGE = -1;
    private final Map<String,Set<U>> followedUser; 
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge, 
            final Map<String,Set<U>> followedUser) {
        super(name, surname, user, userAge);
        this.followedUser = followedUser;
    }

    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedUser = new HashMap<String,Set<U>>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final String firstName, final String lastName, final String username) {
        super(name, surname, user, DEFAULT_AGE);
        this.followedUser = new HashMap<String,Set<U>>();
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    public boolean addFollowedUser(final String circle, final U user) {
        if (this.followedUser.containsKey(circle)) {
                this.followedUser.containsKey(circle);
                final Set<U> setLinkedToValue = this.followedUser.get(circle);
                setLinkedToValue.add(user);
                this.followedUser.put(circle, setLinkedToValue);
        } else {
            final Set<U> set = new HashSet<U>();
            this.followedUser.put(circle, set);
            set.add(user);
        }
        return true;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        for (final String i : this.followedUser.keySet()) {
            if (i.equals(groupName)) {
                return new HashSet<U>(this.followedUser.get(groupName));
            }
        }
        return new HashSet<U>();
    }

    public List<U> getFollowedUsers() {
        final List<U> list = new ArrayList<>();
        for (final Set<U> setUser : this.followedUser.values()) {
            list.addAll(setUser);
        }
        return list;
    }
}
