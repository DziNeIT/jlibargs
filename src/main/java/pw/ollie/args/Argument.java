/*
 * This file is part of jlibargs, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014-2019 Oliver Stanley <http://ollie.pw>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pw.ollie.args;

/**
 * A wrapper around a {@link String} which allows for parsing of many primitive
 * data types as well as providing methods to check whether the argument is a
 * valid form of said primitive types.
 *
 * Argument objects are immutable and any methods which may appear to make
 * a modification(s) to the state of the Argument will return a new object.
 */
public class Argument {
    /**
     * The raw string for the argument wrapped by this Argument object.
     */
    private final String raw;

    /**
     * Creates a new Argument, using the given String argument as a raw
     * string.
     *
     * @param arg the raw string for this Argument
     */
    public Argument(String arg) {
        if (arg == null) {
            throw new IllegalArgumentException();
        }
        this.raw = arg;
    }

    /**
     * Gets the raw string this Argument wraps.
     *
     * @return this Argument's raw String value
     */
    public String get() {
        return raw;
    }

    /**
     * Returns this Argument's value parsed as an int.
     *
     * @return this Argument's value parsed as an int
     * @throws NumberFormatException if the value isn't an int
     */
    public int asInt() {
        return Integer.parseInt(raw);
    }

    /**
     * Returns this Argument's value parsed as a double.
     *
     * @return this Argument's value parsed as a double
     * @throws NumberFormatException if the value isn't a double
     */
    public double asDouble() {
        return Double.parseDouble(raw);
    }

    /**
     * Returns this Argument's value parsed as a float.
     *
     * @return this Argument's value parsed as a float
     * @throws NumberFormatException if the argument isn't a float
     */
    public float asFloat() {
        return Float.parseFloat(raw);
    }

    /**
     * Returns this Argument's value parsed as a long.
     *
     * @return this Argument's value parsed as a long
     * @throws NumberFormatException if the value isn't a long
     */
    public long asLong() {
        return Long.parseLong(raw);
    }

    /**
     * Returns this Argument's value parsed as a short.
     *
     * @return this Argument's value parsed as a short
     * @throws NumberFormatException if the value isn't a short
     */
    public short asShort() {
        return Short.parseShort(raw);
    }

    /**
     * Returns this Argument's value parsed as a boolean.
     *
     * @return this Argument's value parsed as a boolean
     */
    public Boolean asBoolean() {
        return Boolean.valueOf(raw);
    }

    /**
     * Returns this Argument's value parsed as a Character. {@code null} is
     * returned if the raw string is not one character long.
     *
     * @return this Argument's value parsed as a Character
     */
    public Character asChar() {
        return raw.length() == 1 ? raw.charAt(0) : null;
    }

    /**
     * Checks whether this Argument's value can be parsed as an integer.
     *
     * @return whether this Argument's value can be parsed as an integer
     */
    public boolean isInt() {
        try {
            asInt();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks whether this Argument's value can be parsed as a double.
     *
     * @return whether this Argument's value can be parsed as a double
     */
    public boolean isDouble() {
        try {
            asDouble();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks whether this Argument's value can be parsed as a float.
     *
     * @return whether this Argument's value can be parsed as a float
     */
    public boolean isFloat() {
        try {
            asFloat();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks whether this Argument's value can be parsed as a long.
     *
     * @return whether this Argument's value can be parsed as a long
     */
    public boolean isLong() {
        try {
            asLong();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks whether this Argument's value can be parsed as a short.
     *
     * @return whether this Argument's value can be parsed as a short
     */
    public boolean isShort() {
        try {
            asShort();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks whether this Argument's value can be parsed as a boolean.
     *
     * @return whether this Argument's value can be parsed as a boolean
     */
    public boolean isBoolean() {
        return raw.equals("true") || raw.equals("false");
    }

    /**
     * Checks whether this Argument's value can be parsed as a char.
     *
     * @return whether this Argument's value can be parsed as a char
     */
    public boolean isChar() {
        return raw.length() == 1;
    }

    /**
     * @return {@code raw.intern()}
     * @see {@link String#intern()}
     */
    public String getIntern() {
        return raw.intern();
    }

    /**
     * @param string the string to add to the end of the current string
     * @return {@code new Argument(raw.concat(string))}
     * @see {@link String#concat(String)}
     */
    public Argument concat(String string) {
        return new Argument(raw.concat(string));
    }

    /**
     * @param startIndex the start of the substring
     * @param endIndex the end of the substring
     * @return {@code new Argument(raw.substring(startIndex, endIndex))}
     * @see {@link String#substring(int, int)}
     */
    public Argument substring(int startIndex, int endIndex) {
        return new Argument(raw.substring(startIndex, endIndex));
    }

    /**
     * @param startIndex the start of the substring
     * @return {@code new Argument(raw.substring(startIndex))}
     * @see {@link String#substring(int)}
     */
    public Argument substring(int startIndex) {
        return new Argument(raw.substring(startIndex));
    }

    /**
     * @return {@code new Argument(raw.toLowerCase())}
     * @see {@link String#toLowerCase()}
     */
    public Argument toLowerCase() {
        return new Argument(raw.toLowerCase());
    }

    /**
     * @return {@code new Argument(raw.toUpperCase())}
     * @see {@link String#toUpperCase()}
     */
    public Argument toUpperCase() {
        return new Argument(raw.toUpperCase());
    }

    /**
     * @return {@code raw.toCharArray()}
     * @see {@link String#toCharArray()}
     */
    public char[] toCharArray() {
        return raw.toCharArray();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Argument && ((Argument) other).raw
                .equals(raw);
    }

    @Override
    public int hashCode() {
        return raw.hashCode();
    }

    @Override
    public String toString() {
        return raw.intern();
    }
}
