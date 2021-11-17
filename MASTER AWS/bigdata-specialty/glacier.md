# Amazon Glacier
- Lower cost

Vault lock:

- Feature: compliance requirement to keep data for a given time range disallowing any modification to it.
- Enforce controls for a vault with a vault lock policy
     - Policy: Locked for editing.
        - time-based retention and "undeleteable", or both.
        - control is implemented through IAM policies
     - `glacier:DeleteArchive` is locked for 365.
     - Note: rules in a policy, first rules have higher precedence.
 - Vault lock steps:
    - Init
        - lock goes to `InProgress` state, a `lock ID` is returned
        - have 24hrs to validate the lock (expires after 24h)
    - Complete Vault lock (validate)
        - State transitions: `InProgress` -> `Locked`.
     