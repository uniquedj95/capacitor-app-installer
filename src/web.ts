import { WebPlugin } from '@capacitor/core';

import type { CapacitorAppInstallerPlugin } from './definitions';

export class CapacitorAppInstallerWeb extends WebPlugin implements CapacitorAppInstallerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
