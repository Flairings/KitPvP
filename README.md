#                KitPvP
Documentation & Assets

##      APIs
```
KitPvP uses API's to handle it's in-game UI's such as /help, can be found in the me.flairings.kitpvp.config
Scoreboard: https://github.com/ThatKawaiiSam/Assemble
Tablist: https://github.com/ceezuns/Poseidon
```

##      Libraries
```
KitPvP depends on various plugins found in the "libs" folder
AquaCore
BetterTeams
```

##      Commands
KitPvP consists of multiple commands
```
commands:
  kitpvp:
    description: Help command for KitPvP plugin.
    |- Subcommands 
    |-- /kitpvp 
    |-- /kitpvp howtoplay
    |-- /kitpvp stats
    |-- /kitpvp build
    |-- /kitpvp reload
    |-- /kitpvp killrewards
    
  stats:
    description: Check your kills and deaths statistics.
    aliases:
      - statistics
      - kdr
      - kd
  howtoplay:
    description: How To Play GUI
    aliases:
      - help
  build:
    description: Enable and Disable breaking & placing blocks.
    aliases:
      - buildmode
  kitpvp-reload:
    description: Safely reloads the kitpvp core.
  profile:
    description: Change a users profile settings

permissions:
  kitpvp.command.helpcommand:
    description: This is the main help command to KitPvP

  kitpvp.helpcommand.howtoplay:
    description: This allows use of the subcommand "/kitpvp helpui"

  kitpvp.helpcommand.stats:
    description: This allows use of the subcommand "/kitpvp stats"

  kitpvp.helpcommand.build:
    description: This allows use of the subcommand "/kitpvp build"

  kitpvp.command.build:
    description: This permission allows the use of /build. find out more about /build with "/kitpvp build"

  kitpvp.helpcommand.reload:
    description: This permission allows the user to reload the kitpvp core.

  kitpvp.command.howtoplay:
    description: This permission allows the user to access the help user interface, find out more about /help with "/kitpvp help"

  kitpvp.command.reload:
    description: This permission allows the user to reload the kitpvp core.

  kitpvp.helpcommand.killrewards:
    description: This permission allows the user to view the current kill reward settings

  kitpvp.command.stats:
    description: View the stats
```
##      Configuration
KitPvP's config is highly editable, all messages, variables, placeholders, and UI's are changeable to your liking.


## License
[MIT](https://choosealicense.com/licenses/mit/)
