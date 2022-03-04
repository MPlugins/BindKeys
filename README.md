# BindKeys 
### *Bind actions to specific key being pressed*

This plugin allows you to let the server execute commands when a player presses a specific key on their keyboard.

**Currently available keys are**:
* *F*
* *Q*
* *shift + F*
* *shift + Q*

## Config

`permission`: Permission needed to use keybinding.

`enabled`: Whether this keybinding is active (can be used)

`cancel-events`: Every keybinding is bound to an event. This option says whether the default event action should be canceled or not. The events are:
* Switch items when `F` is pressed.
* Drop item when `Q` is pressed.

`cooldown`: Time in seconds a player needs to wait before the keybinding can be used again.

`commnds`: A list of commands (without `/`)that should be executed when the keybinding is used.

**Example Config:**
```yaml
keybindings:
  # When F is pressed
  f:
    # Permission needed to use this keybinding. Leave empty for no permission.
    permission: permission
    # Whether this keybinding should be enabled (true|false)
    enabled: true
    cancel-event: true
    cooldown: 10
    commands:
      - say [f] first command
      - say [f] second command

  # When Q is pressed
  q:
    # Permission needed to use this keybinding. Leave empty for no permission.
    permission: permission
    # Whether this keybinding should be enabled (true|false)
    enabled: true
    cancel-event: true
    cooldown: 10
    commands:
      - say [q] first command
      - say [q] second command

  # When SHIFT + F is pressed
  shift-f:
    # Permission needed to use this keybinding. Leave empty for no permission.
    permission: permission
    # Whether this keybinding should be enabled (true|false)
    enabled: true
    cancel-event: true
    cooldown: 10
    commands:
      - say [shift-f] first command
      - say [shift-f] second command

  # When SHIFT + Q is pressed
  shift-q:
    # Permission needed to use this keybinding. Leave empty for no permission.
    permission: permission
    # Whether this keybinding should be enabled (true|false)
    enabled: true
    cancel-event: true
    cooldown: 10
    commands:
      - say [shift-q] first command
      - say [shift-q] second command
```


