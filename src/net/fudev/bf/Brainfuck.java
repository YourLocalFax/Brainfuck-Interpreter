/**
 * Copyright (C) 2015 Sekai Kyoretsuna
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package net.fudev.bf;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @author Sekai Kyoretsuna
 */
public class Brainfuck
{
   /**
    * The default size, in bytes, of brainfuck memory given to each program.
    */
   public static final int DEFAULT_MEM_SIZE = 65535;
   
   private InputStream input = System.in;
   private PrintStream output = System.out;
   
   /**
    * @return The current InputStream this brainfuck state is using.
    */
   public InputStream getInput()
   {
      return input;
   }
   
   /**
    * Sets the current InputStream for this brainfuck state. It cannot be null.
    * 
    * @param input
    *           The desired InputStream.
    */
   public void setInput(final InputStream input)
   {
      if (input == null)
      {
         throw new NullPointerException();
      }
      this.input = input;
   }
   
   /**
    * @return The current PrintStream this brainfuck state is using.
    */
   public PrintStream getOutput()
   {
      return output;
   }
   
   /**
    * Sets the current PrintStream for this brainfuck state. It cannot be null.
    * 
    * @param output
    *           The desired PrintStream.
    */
   public void setOutput(final PrintStream output)
   {
      if (output == null)
      {
         throw new NullPointerException();
      }
      this.output = output;
   }
   
   /**
    * Interprets the given char[] as brainfuck code, using the default memSize as the size of memory in bytes.
    * 
    * @param source
    *           The source to interpret.
    * @throws IOException
    */
   public void interpret(final String source) throws IOException
   {
      interpret(source.toCharArray(), DEFAULT_MEM_SIZE);
   }
   
   /**
    * Interprets the given char[] as brainfuck code, using the given memSize as the size of memory in bytes.
    * 
    * @param source
    *           The source to interpret.
    * @param memSize
    *           How large, in bytes, to make brainfuck's memory.
    * @throws IOException
    */
   public void interpret(final String source, final int memSize) throws IOException
   {
      interpret(source.toCharArray(), memSize);
   }
   
   /**
    * Interprets the given char[] as brainfuck code, using the default memSize as the size of memory in bytes.
    * 
    * @param source
    *           The source to interpret.
    * @throws IOException
    */
   public void interpret(final char[] source) throws IOException
   {
      interpret(source, DEFAULT_MEM_SIZE);
   }
   
   /**
    * Interprets the given char[] as brainfuck code, using the given memSize as the size of memory in bytes.
    * 
    * @param source
    *           The source to interpret.
    * @param memSize
    *           How large, in bytes, to make brainfuck's memory.
    * @throws IOException
    */
   public void interpret(final char[] source, final int memSize) throws IOException
   {
      final byte[] mem = new byte[memSize];
      final int length = source.length;
      int p = 0, l = 0;
      char c = 0;
      for (int i = 0; i < length; i++)
      {
         switch (source[i])
         {
            case '>':
               p = p == memSize - 1 ? 0 : p + 1;
               continue;
            case '<':
               p = p == 0 ? memSize - 1 : p - 1;
               continue;
            case '+':
               mem[p]++;
               continue;
            case '-':
               mem[p]--;
               continue;
            case '.':
               output.print((char) mem[p]);
               continue;
            case ',':
               mem[p] = (byte) (input.read() & 0xFF);
               continue;
            case '[':
               if (mem[p] == 0)
               {
                  i++;
                  while (l > 0 || source[i] != ']')
                  {
                     if ((c = source[i]) == '[')
                     {
                        l++;
                     }
                     else if (c == ']')
                     {
                        l--;
                     }
                     i++;
                  }
               }
               continue;
            case ']':
               if (mem[p] != 0)
               {
                  i--;
                  while (l > 0 || source[i] != '[')
                  {
                     if ((c = source[i]) == ']')
                     {
                        l++;
                     }
                     else if (c == '[')
                     {
                        l--;
                     }
                     i--;
                  }
                  i--;
               }
               continue;
            default:
               continue;
         }
      }
   }
}
