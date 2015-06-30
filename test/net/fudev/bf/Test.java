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

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Sekai Kyoretsuna
 */
public final class Test
{
   public static void main(final String[] args) throws IOException
   {
      final BrainfuckState state = new BrainfuckState();
      // A standard HelloWorld app
      state.interpret("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
      // A more complicated HelloWorld app
      state.interpret(">++++++++[<+++++++++>-]<.>>+>+>++>[-]+<[>[->+<<++++>]<<]>.+++++++..+++.>>+++++++.<<<[[-]<[-]>]<+++++++++++++++.>>.+++.------.--------.>>+.>++++.");
      // A brainfuck interpreter. Give input in the form of source!input
      state.setInput(new ByteArrayInputStream("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.!".getBytes()));
      state.interpret("dbfi>>>+[[-]>>[-]++>+>+++++++[<++++>>++<-]++>>+>+>+++++[>++>++++++<<-]+>>>,<++[[>[->>]<[>>]<<-]<[<]<+>>[>]>[<+>-[[<+>-]>]<[[[-]<]++<-[<+++++++++>[<->-]>>]>>]]<<]<]<[[<]>[[>]>>[>>]+[<<]<[<]<+>>-]>[>]+[->>]<<<<[[<<]<[<]+<<[+>+<<-[>-->+<<-[>+<[>>+<<-]]]>[<+>-]<]++>>-->[>]>>[>>]]<<[>>+<[[<]<]>[[<<]<[<]+[-<+>>-[<<+>++>-[<->[<<+>>-]]]<[>+<-]>]>[>]>]>[>>]>>]<<[>>+>>+>>]<<[->>>>>>>>]<<[>.>>>>>>>]<<[>->>>>>]<<[>,>>>]<<[>+>]<<[+<<]<]");

      state.setInput(new ByteArrayInputStream("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.!".getBytes()));
      state.interpret("cgbfi>>>>>+[->>++>+>+++++++[<++++>>++<-]++>>+>+>+++++[>++>++++++<<-]+>>>,<++[[>[->>]<[>>]<<-]<[<]<+>>[>]>[<+>-[[<+>-]>]<[[[-]<]++<-[<+++++++++>[<->-]>>]>>]]<<]>[-]+<<[--[[-]>>->+<<<]>>[-<<<<[>+<-]>>>>>>+<]<<]>>[-]<<>>>[<<<+>>>-]<<<]>>>+<<<<[<<]>>[[<+>>+<-]+<-[-[-[-[-[-[-[->->>[>>]>>[>>]<+<[<<]<<[<<]<]>[->>[>>]>>[>>]<,<[<<]<<[<<]]<]>[->>[>>]>>[>>]<-<[<<]<<[<<]]<]>[->>[>>]>>[>>]<.<[<<]<<[<<]]<]>[->>[>>]>>[>>]<<-<<[<<]<<[<<]]<]>[->>[>>]>>[>>]+[<<]<<[<<]]<]>[->>[>>]>>[>>]<[>+>>+<<<-]>[<+>-]>>[<<+>>[-]]+<<[>>-<<-]>>[<<+>>>>+<<-]>>[<<+>>-]<<[>>+<<-]+>>[<<->>-]<<<<[-<<[<<]<<[<<]<<<<<++>>]>>[-<<<<<<[<<]<<[<<]<]>]<]>[->>[>>]>>[>>]<[>+>>+<<<-]>[[<+>-]>>[-]+<<]>>[<<+>>>>+<<-]>>[<<+>>-]<<[>>+<<-]+>>[<<->>-]<<<<[-<<[<<]<<[<<]<<<<<+>>]>>[-<<<<<<[<<]<<[<<]<]>]>[<+>-]<<<<<<[>>+<<-[->>->>+[>>>[-<+>>+<]+<-[-[[-]>[-]<]>[-1<<<+>>>]<]>[-<<<->>>]>[-<+>]<<<<[>>+<<-]>>]<<<<<<]>>[-<<+[>>>[-<+>>+<]+<-[-[[-]>[-]<]>[-1<<<->>>]<]>[-<<<+>>>]>[-<+>]<<<<[<<+>>-]<<]]]>>>>>>>]");
   }
   
   private Test()
   {
   }
}
