/* tslint:disable */
/* eslint-disable */
/**
 * Gateway Service API
 * API for Gateway
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import {
    EmployeeDto,
    EmployeeDtoFromJSON,
    EmployeeDtoFromJSONTyped,
    EmployeeDtoToJSON,
} from './EmployeeDto';

/**
 * 
 * @export
 * @interface DepartmentDto
 */
export interface DepartmentDto {
    /**
     * 
     * @type {Array<EmployeeDto>}
     * @memberof DepartmentDto
     */
    employees?: Array<EmployeeDto>;
    /**
     * 
     * @type {number}
     * @memberof DepartmentDto
     */
    id?: number;
    /**
     * 
     * @type {string}
     * @memberof DepartmentDto
     */
    name?: string;
    /**
     * 
     * @type {number}
     * @memberof DepartmentDto
     */
    organizationId?: number;
}

export function DepartmentDtoFromJSON(json: any): DepartmentDto {
    return DepartmentDtoFromJSONTyped(json, false);
}

export function DepartmentDtoFromJSONTyped(json: any, ignoreDiscriminator: boolean): DepartmentDto {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'employees': !exists(json, 'employees') ? undefined : ((json['employees'] as Array<any>).map(EmployeeDtoFromJSON)),
        'id': !exists(json, 'id') ? undefined : json['id'],
        'name': !exists(json, 'name') ? undefined : json['name'],
        'organizationId': !exists(json, 'organizationId') ? undefined : json['organizationId'],
    };
}

export function DepartmentDtoToJSON(value?: DepartmentDto | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'employees': value.employees === undefined ? undefined : ((value.employees as Array<any>).map(EmployeeDtoToJSON)),
        'id': value.id,
        'name': value.name,
        'organizationId': value.organizationId,
    };
}
