from actions.appliance import Appliance
from actions.door import Door
from actions.security import Security

from appliance_commands import ApplianceOnCommand, ApplianceOffCommand
from door_commands import DoorLockCommand, DoorUnlockCommand
from security_commands import SecurityArmCommand, SecurityDisarmCommand
from menu_action import MenuAction

# instantiate new objects
menu_action = MenuAction()
frontdoor = Door('Front Door')
frontdoor_lock = DoorLockCommand(frontdoor)
frontdoor_unlock = DoorUnlockCommand(frontdoor)

# Set up the commands
menu_action.set_command(frontdoor, frontdoor_lock, frontdoor_unlock)

# Try the commands with undo
menu_action.activate(frontdoor)
menu_action.deactivate(frontdoor)
menu_action.deactivate(frontdoor)
menu_action.undo()
menu_action.undo()
menu_action.undo()

# Extra undo to test empty queue
menu_action.undo()

