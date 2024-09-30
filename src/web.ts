import { WebPlugin } from '@capacitor/core';

import type { AppInstallOptions, CapacitorAppInstallerPlugin } from './definitions';

export class CapacitorAppInstallerWeb extends WebPlugin implements CapacitorAppInstallerPlugin {
  async install(options: AppInstallOptions): Promise<void> {
    console.log('INSTALLING', options);
  }
}
