package com.symphony.bdk.bot.sdk.command;

import java.util.function.Predicate;

import com.symphony.bdk.bot.sdk.event.model.MessageEvent;

/**
 * Filters Symphony chat messages looking for bot commands.
 *
 * @author Marcus Secato
 *
 */
public interface CommandFilter {

  /**
   * Registers a command filter
   *
   * @param commandName the command name. Should match the channel configured in
   *        CommandDispatcher.
   * @param filter the filter predicate
   */
  void addFilter(String commandName, Predicate<String> filter);

  /**
   * Registers a default command filter. Used to return standard messages when
   * bot is not fed with a valid command.
   *
   * @param commandName the command name. Should match the channel configured in
   *        CommandDispatcher.
   * @param defaultFilter the default filter predicate
   */
  void setDefaultFilter(String commandName, Predicate<String> defaultFilter);

  /**
   * Performs the actual message filtering based on registered filters. If the
   * message corresponds to a valid command, {@link CommandDispatcher} will be
   * called.
   *
   * @param messageEvent the message to be filtered
   */
  void filter(MessageEvent messageEvent);
}
